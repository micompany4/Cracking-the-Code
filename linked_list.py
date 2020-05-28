# Node class from https://www.tutorialspoint.com/python_data_structure/python_linked_lists.htm
class Node:
    def __init__(self, dataval=None):
        self.dataval = dataval
        self.nextval = None


class SLinkedList:
    def __init__(self):
        self.headval = None


e1 = Node(1)
e2 = Node(2)
e3 = Node(1)
e4 = Node(4)
e5 = Node(2)
e6 = Node(8)

e1.nextval = e2
e2.nextval = e3
e3.nextval = e4
e4.nextval = e5
e5.nextval = e6


def question1(head):
    print("question 1: remove duplicates")
    tracker = head
    numbers = [e1.dataval]
    while tracker is not None:
        if tracker.nextval is None:
            break
        if tracker.nextval.dataval in numbers:
            tracker.nextval = tracker.nextval.nextval
        else:
            numbers.append(tracker.nextval.dataval)
        tracker = tracker.nextval

    tracker = e1
    while tracker is not None:
        print(tracker.dataval)
        tracker = tracker.nextval


def question2(head, k):
    print("question2: return the kth to last element")
    tracker = head
    while tracker is not None:
        temp = tracker
        i = 0
        while i < k:
            temp = temp.nextval
            i += 1
        if temp is None:
            return tracker
        tracker = tracker.nextval


# question1(e1)
print(question2(e1, 2).dataval)
print("done")
