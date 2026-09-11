//////////////
//
// QUEUE
//
//////////////
#include<iostream>
using namespace std;
#pragma pack(1)
struct node 
{
    int data;
    struct node* next;
};

class Queue
{
    private:
        struct node *first;
        int iCount;

    public:
        Queue();
        void Enqueue(int iNo);  //InsertLast
        int Dequeue();           //DeleteFirst
        void Display();
        int Count();
};

Queue :: Queue()
{
    this->first = NULL;
    this->iCount = 0;
}
void Queue :: Enqueue(int iNo)
{
    struct node* newn = NULL;
    struct node* temp = NULL;

    newn = new struct node();
    newn->data = iNo;
    newn->next = NULL;

    if(first == NULL)
    {
        first = newn;
    }
    else
    {
        temp = first;
        while(temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = newn;
    }
    iCount++;
}
int Queue :: Dequeue()  
{
    int iValue = 0;
    struct node* temp = NULL;

    if(first == NULL)
    {
        cout<<"Queue is empty\n";
        return -1;
    }
    else 
    {
        iValue = first->data;
        temp = first;

        first = first->next;
        delete(temp);

        iCount--;

        return iValue;
    }
}        
        
void Queue :: Display()
{
    struct node* temp = NULL;
    temp = first;

    while(temp != NULL)
    {
        cout<<"| "<<temp->data<<" |\n";
        temp = temp->next;
    }
}
int Queue :: Count()
{
    return iCount;
}


int main()
{
    Queue qobj;
    int iRet = 0;

    qobj.Enqueue(11);
    qobj.Enqueue(21);
    qobj.Enqueue(51);
    qobj.Enqueue(101);
    
    qobj.Display();
    iRet = qobj.Count();
    cout<<"Elements of the Queue are : "<<iRet<<endl;

    iRet  = qobj.Dequeue();
    cout<<"removed  element is  : "<<iRet<<"\n";
    qobj.Display();
    iRet = qobj.Count();
    cout<<"Elements of the Queue are : "<<iRet<<endl;

    return 0;
}