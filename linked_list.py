# Node class from https://www.tutorialspoint.com/python_data_structure/python_linked_lists.htm
class Node:
    def __init__(self, dataval=None):
        self.dataval = dataval
        self.nextval = None


class SLinkedList:
    def __init__(self):
        self.headval = None


# create the nodes for the linked list: modify to what the question requires
e1 = Node(1)
e2 = Node(2)
e3 = Node(3)
e4 = Node(4)
e5 = Node(5)
e6 = Node(6)

# creates the next references
e1.nextval = e2
e2.nextval = e3
# e3.nextval = e4
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


# assuming the two numbers are represented by their own single linked list
# and that they pass the head of the list fairly :)
def question5(val1, val2):
    print("question 5: sum list")
    num1 = ""
    num2 = ""
    while val1 is not None:
        num1 = "".join((str(val1.dataval), num1))
        val1 = val1.nextval
    while val2 is not None:
        num2 = "".join((str(val2.dataval), num2))
        val2 = val2.nextval

    num1 = int(num1)
    num2 = int(num2)
    print(num1)
    print(num2)
    print("sum:", end=" ")
    return num1 + num2


def question7(head1, head2):
    tracker1 = head1
    tracker2 = head2
    while tracker1 is not None:
        while tracker2 is not None:
            if tracker1.nextval is tracker2.nextval:
                return tracker1.nextval
            tracker2 = tracker2.nextval
        tracker1 = tracker1.nextval
        tracker2 = head2
    return None


def question8(head):
    print("question 8: loop detection")
    tracker = head
    letters = []
    while tracker is not None:
        if tracker.dataval in letters:
            return tracker
        letters.append(tracker.dataval)
        tracker = tracker.nextval


# question1(e1)
# print(question2(e1, 2).dataval)
# print(question5(e1, e4))
# check if there is an intersecting node
if question7(e1, e4) is not None:
    print(question7(e1, e4).dataval)
else:
    print("no intersecting node found")
# print(question8(e1).dataval)

print("done")
