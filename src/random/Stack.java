package random;

public class Stack 
{
	Node head, temp;
	public void push(char ch)
	{
		if(head==null)
			head=new Node(ch);
		else
		{
			temp=head;
			head=new Node(ch);
			head.next=temp;
		}
	}
	public char pop()
	{
		if(head==null)
			return ' ';
		else
		{
			char ch=head.data;
			head=head.next;
			return ch;
		}
	}
}
