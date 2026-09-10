/////////////////////
//
// Singly Linear LL
//
/////////////////////

#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
};


void Display(struct node* first)
{
    while(first != NULL)        //Type1 of while loop
    {
        printf("| %d | ->",first->data);
        first = first->next;
    }
    printf("NULL\n");
}

int Count(struct node* first)
{
    int iCount = 0;
    while(first != NULL) //Type1 loop
    {
        iCount++;
        first = first->next;
    }
    return iCount;
}

void InsertFirst(struct node** first, int iNo)
{
    struct node* newn = NULL;
    newn = (struct node*)malloc(sizeof(struct node));

    newn->data = iNo;
    newn->next = NULL;
    
    
    if(NULL == *first) //LL is empty
    {
        *first = newn;
    }
    else               //LL contains at least one node
    {
       newn->next = *first;
       *first = newn;
    }
}

void InsertLast(struct node** first, int iNo)
{
    struct node* newn = NULL;
    struct node* temp = NULL;
    newn = (struct node*)malloc(sizeof(struct node));

    newn->data = iNo;
    newn->next = NULL;

    if(*first == NULL) //LL is empty
    {
        *first = newn;
    }
    else
    {
       temp = *first;
       while(temp->next !=NULL)
       {
        temp = temp->next;
       }
       temp->next = newn;

    }
}

void InsertAtPos(struct node** first, int iNo, int iPos)
{
    int iCount = 0;
    int i =0;

    struct node* newn = NULL;
    struct node* temp = NULL;

    iCount = Count(*first);
    
    //Filter
    if((iPos < 1) || (iPos > iCount+1))
    {
        printf("Invalid Position");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(first,iNo);
    }
    else if(iPos == iCount+1)
    {
        InsertLast(first,iNo);
    }
    else 
    {
      newn = (struct node*)malloc(sizeof(struct node));

      newn->data = iNo;
      newn->next = NULL;

      temp = *first;

      for(i = 1; i < iPos-1; i++)
      {
        temp = temp->next;
      }

      newn->next = temp->next;
      temp->next = newn;
    }


}

void DeleteFirst(struct node** first)
{
    struct node** temp = NULL;
    if(*first == NULL)            //LL is empty
    {
      return;
    }
    else if((*first)->next == NULL) //LL contains one node
    {
      free(*first);
      *first = NULL;
    }
    else                          
    {
      temp = *first;
      *first = (*first)->next;
      free(temp);
    }
}

void Deletelast(struct node** first)
{
    struct node* temp = NULL;
    if(*first == NULL)            //LL is empty
    {
      return;
    }
    else if((*first)->next == NULL) //LL contains one node
    {
      free(*first);
      *first = NULL;
    }
    else                          //LL contains more than 1 node
    {
      temp = *first;
      while(temp->next->next != NULL) //Type3 of while
      {
        temp = temp->next;
      }
      free(temp->next);
      temp->next = NULL;
    }
}

void DeleteAtPos(struct node** first, int iPos)
{
    int iCount = 0;
    int i = 0;

    struct node* temp = NULL;
    struct node* target = NULL;

    iCount = Count(*first);
    //Filter
    if((iPos < 1) || (iPos > iCount))
    {
        printf("Invalid Position");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(first);
    }
    else if(iPos == iCount)
    {
        Deletelast(first);
    }
    else 
    {
        temp = *first;
        for(i = 1; i < iPos-1; i++)
        {
            temp = temp->next;
        }
        target = temp->next;

        temp->next = target->next;
        free(target);
    }
}

int main()
{
    struct node* head = NULL;
    int iRet = 0;

    InsertFirst(&head,101);
    InsertFirst(&head,51);
    InsertFirst(&head,21);
    InsertFirst(&head,11);

    Display(head);
    iRet = Count(head);
    printf("Number of nodes are : %d\n",iRet);

    InsertLast(&head,111);
    InsertLast(&head,121);

    Display(head);
    iRet = Count(head);
    printf("Number of nodes are : %d\n",iRet);

    DeleteFirst(&head);
    Display(head);
    iRet = Count(head);
    printf("Number of nodes are : %d\n",iRet);

    Deletelast(&head);
    Display(head);
    iRet = Count(head);
    printf("Number of nodes are : %d\n",iRet);

    InsertAtPos(&head,105,4);
    Display(head);
    iRet = Count(head);
    printf("Number of nodes are : %d\n",iRet);

    DeleteAtPos(&head,4);
    Display(head);
    iRet = Count(head);
    printf("Number of nodes are : %d\n",iRet);

    return 0;
}