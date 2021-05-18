#include <stdio.h>
#include <mm_malloc.h>

#define MAX_SIZE 26 //允许出现的最大数量进程

int pid = 0;//进程的编号

//一个进程的表示
typedef struct PCB {
    int PID;//进程的PID
    char name;//进程的名字，可以用字母表示
    struct PCB *next;
};

typedef struct Queue {
    //分别对应的是就绪队列的头和尾指针，阻塞队列的头和尾指针以及运行队列的头指针
    struct PCB readyHead;
    struct PCB readyRear;
    struct PCB blockHead;
    struct PCB blockRear;
    struct PCB running;
};

struct Queue queue;

//在队列尾部加入元素
void enQueue(struct PCB *queueRear, struct PCB *queueHead, struct PCB *pcb) {
    if (queueRear->next != NULL)
        queueRear->next->next = pcb;
    if (queueHead->next == NULL)
        queueHead->next = pcb;
    queueRear->next = pcb;
}

//返回对头元素
struct PCB *deQueue(struct PCB *queueRear, struct PCB *queueHead) {
    if (queueHead->next == NULL)
        return NULL;
    struct PCB *pcb = queueHead->next;
    queueHead->next = pcb->next;
    if (queueHead->next == NULL)
        queueRear->next = NULL;
    pcb->next = NULL;
    return pcb;
}

//创建出一个进程
void create() {
    if (pid >= MAX_SIZE)
        printf("当前内存已经满了，无法继续添加进程\n");
    struct PCB *pcb = (struct PCB *) malloc(sizeof(struct PCB));
    pcb->name = pid + 'A';
    pcb->PID = ++pid;
    pcb->next = NULL;
    enQueue(&queue.readyRear, &queue.readyHead, pcb);
}

//进程调度
void dispatch() {
    if (queue.readyHead.next == NULL) {
        printf("当前的就绪队列中的进程数为0，无法执行dispatch\n");
        return;
    }
    if (queue.running.next != NULL) {
        printf("当前的运行队列中有进程在运行，无法执行dispatch\n");
        return;
    }
    struct PCB *pcb = deQueue(&queue.readyRear, &queue.readyHead);
    queue.running.next = pcb;
}

//进程时间片使用完
void timeOut() {
    if (queue.running.next == NULL) {
        printf("当前的运行队列中没有进程在运行，无法执行timeOut\n");
        return;
    }
    struct PCB *pcb = queue.running.next;
    queue.running.next = NULL;
    enQueue(&queue.readyRear, &queue.readyHead, pcb);
    dispatch();//自动进行调度
}

//进程阻塞
void eventWait() {
    if (queue.running.next == NULL) {
        printf("当前的运行队列中没有进程在运行，无法执行eventWait\n");
        return;
    }
    struct PCB *pcb = queue.running.next;
    queue.running.next = NULL;
    enQueue(&queue.blockRear, &queue.blockHead, pcb);
    dispatch();//进程阻塞后，自动执行调度
}

//进程唤醒
void eventOccurs() {
    if (queue.blockHead.next == NULL) {
        printf("当前的阻塞队列中的进程数为0，无法执行eventOccurs\n");
        return;
    }
    struct PCB *pcb = deQueue(&queue.blockRear, &queue.blockHead);
    if (queue.readyHead.next == NULL && queue.running.next == NULL) {
        //就绪队列和运行队列为空时，进程从阻塞队列中唤醒时进入运行队列中
        enQueue(&queue.readyRear, &queue.readyHead, pcb);
        dispatch();
        return;
    }
    enQueue(&queue.readyRear, &queue.readyHead, pcb);
}

void showQueue(struct PCB *head) {
    while (head != NULL) {
        printf(" %c", head->name);
        head = head->next;
    }
    printf("\n");
}

//打印队列中的进程信息
void show() {
    struct PCB *ready = queue.readyHead.next;
    struct PCB *run = queue.running.next;
    struct PCB *block = queue.blockHead.next;
    printf("就绪队列： ");
    showQueue(ready);
    printf("运行队列： ");
    showQueue(run);
    printf("阻塞队列： ");
    showQueue(block);
}

int main() {
    int choice = 0;
    printf("1.create\n");
    printf("2.timeOut\n");
    printf("3.dispatch\n");
    printf("4.eventWait\n");
    printf("5.eventOccurs\n");
    printf("6.exit\n");
    printf("请输入你的选择：");
    while (choice != 6) {
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("你的选择：create\n");
                create();
                break;
            case 2:
                printf("你的选择：timeOut\n");
                timeOut();
                break;
            case 3:
                printf("你的选择：dispatch\n");
                dispatch();
                break;
            case 4:
                printf("你的选择：eventWait\n");
                eventWait();
                break;
            case 5:
                printf("你的选择：eventOccurs\n");
                eventOccurs();
                break;
            default:
                break;
        }
        show();
    }
    return 0;
}