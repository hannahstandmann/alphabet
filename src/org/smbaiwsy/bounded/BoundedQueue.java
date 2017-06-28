package org.smbaiwsy.bounded;

/**
 * Implement a queue that has an upper bound.
 * This should be based on a fixed size array.
 * The queue should have enqueue and dequeue methods.
 */
class BoundedQueue<T> {
  private T[] queue;
  private int limit;
  private int last = 0;
  private int first = 0;
  private boolean firstbehindlast = false;
  
  @SuppressWarnings("unchecked")
  public BoundedQueue(int limit){
     this.limit = limit;
     this.queue = (T[])new Object[limit];
  }
  
  public void enqueue(T element) {
     if (this.first == this.last && this.firstbehindlast) throw new IllegalStateException("Upper bound reached");
     this.queue[this.first] = element;
     this.first = this.first+1;
     if (this.first > this.limit - 1 ){
    	 this.first %= this.limit;
    	 this.firstbehindlast = true;
     }
     System.out.println(this.first);
  }
  
  public T dequeue() {
	  System.out.format("%d %d",this.first,this.last);
      if (this.last == this.first && !this.firstbehindlast) throw new IllegalStateException("Empty queue");
      int tmp = this.last;
      this.last = (this.last+1);
      if (this.last > this.limit - 1){
    	  this.last %= this.limit;
    	  this.firstbehindlast = false;
      }
      return this.queue[tmp];
  }
  
  public int getLimit(){
      return this.limit;
  }
}
  

