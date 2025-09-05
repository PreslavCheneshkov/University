#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>
#include <Windows.h>
#include <math.h>
#pragma execution_character_set( "utf-8" )
#pragma warning( disable : 4703 )

struct BinaryTreeNode
{
    float a;
    int b;
    char c[64];
    int stringLength;
    struct BinaryTreeNode* left;
    struct BinaryTreeNode* right;
};

struct LinkedListNode
{
    float a;
    int b;
    char c[64];
    int stringLength;
    struct LinkedListNode* next;
};

int nodeCount;
struct LinkedListNode* currentNode;

void sortInputNodes(BinaryTreeNode* inputNodes)
{
    bool sorted = false;
    while (!sorted)
    {
        bool swapHappened = false;
        for (int i = 0; i < nodeCount - 1; i++)
        {
            if (inputNodes[i].b > inputNodes[i + 1].b)
            {
                BinaryTreeNode tempNode = inputNodes[i];
                inputNodes[i] = inputNodes[i + 1];
                inputNodes[i + 1] = tempNode;
                swapHappened = true;
            }
        }
        if (!swapHappened)
            sorted = true;
    }
}

BinaryTreeNode* convertSortedArrayToBST(BinaryTreeNode* array, int start, int end)
{
    if (start > end)
        return NULL;

    int mid = start + (end - start) / 2;

    struct BinaryTreeNode* root = &array[mid];
    root->left = convertSortedArrayToBST(array, start, mid - 1);
    root->right = convertSortedArrayToBST(array, mid + 1, end);
    return root;
}

BinaryTreeNode* createBinaryTree()
{
    printf("Моля въведете броя на възлите в дървото:\n");
    scanf_s("%d", &nodeCount);

    BinaryTreeNode* inputNodes = new BinaryTreeNode[nodeCount];
    char buffer[1];


    for (int i = 0; i < nodeCount; i++)
    {
        printf("Моля въведете данните за %d-ия елемент:\n", i + 1);
        printf("Реално число за 'а': ");
        scanf_s("%f", &inputNodes[i].a);
        printf("Цяло число за 'b': ");
        scanf_s("%i", &inputNodes[i].b);
        printf("Дължина на низ за 'c' (максимална стойност 64): ");
        scanf_s("%i", &inputNodes[i].stringLength);
        printf("Символен низ за 'c': ");
        gets_s(buffer);
        gets_s(inputNodes[i].c);
        printf("\n\n===========================================================================\n\n");
    }
    sortInputNodes(inputNodes);

    return convertSortedArrayToBST(inputNodes, 0, nodeCount - 1);
}

void copyCValue(char treeC[64], char linkedListC[64], int stringLength)
{
    for (int i = 0; i < stringLength; i++)
    {
        linkedListC[i] = treeC[i];
    }
}

void convertBinarySearchTreeToLinkedList(BinaryTreeNode* root)
{
    if (root == NULL)
    {
        return;
    }

    convertBinarySearchTreeToLinkedList(root->left);

    currentNode->a = root->a;
    currentNode->b = root->b;
    currentNode->stringLength = root->stringLength;
    copyCValue(root->c, currentNode->c, root->stringLength);

    currentNode->next = new LinkedListNode();
    currentNode = currentNode->next;

    convertBinarySearchTreeToLinkedList(root->right);
}

// The chosen node is the one with the highest 'b' value, among the nodes whoose 'c' value has a length of 5
void printTheChosenNodePosition(LinkedListNode* head)
{
    bool hasChosenNode = false;
    int chosenNodeIndex = 0;
    int index = 0;
    LinkedListNode* currentNode = head;

    // The last node is always the largest, since the BST used the 'b' value
    while (currentNode != NULL)
    {
        if (currentNode->stringLength == 5)
        {
            hasChosenNode = true;
            chosenNodeIndex = index;
        }
        currentNode = currentNode->next;
        index++;
    }
    if (hasChosenNode)
        printf("Позицията на търсения елемент в едносвързания списък е: %d", chosenNodeIndex + 1);
}

int main()
{
    SetConsoleOutputCP(65001);
    struct BinaryTreeNode* root;
    currentNode = new LinkedListNode();
    struct LinkedListNode* head = currentNode;

    char userInput;
    do {
        system("CLS");
        printf("Добре дошли в програмата за преобразуване на бинарно дърво в едносвързан списък!\n");
        printf("Моля изберете следващо действие!\n");
        printf("a => Създайте Бинарно дърво\n");
        printf("b => Превърнете бинарното дърво в единично свързан списък\n");
        printf("c => Отпечатайте поредния номер на елемента в структурата, за който в полето 'b' има най - голяма стойност измежду всички елементи, които в полето 'c' съдържат низ с дължина 5 символа. \n");
        printf("0 => Изход от програмата\n");
        userInput = _getch(); printf("\n");

        switch (userInput)
        {
        case 'a': root = createBinaryTree(); break;
        case 'b': convertBinarySearchTreeToLinkedList(root); 
            printf("Успешно създадено бинарно дърво!"); _getch(); break;
        case 'c': printTheChosenNodePosition(head); _getch(); break;
            default: return -1;
        }
    } while (userInput != '0');
}
