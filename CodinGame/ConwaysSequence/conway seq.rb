#this method parses the line a and gives the next line
def parse(a)
    n = a.length
    c=0		#count
    ar = []
    last = a[0] #initialize the #last element to the first element of this sequence
    for i in 0..n do
        if last != a[i]	# a new element ? 
            ar << c	#append the last elements' count
            ar << last 	#append the last element
            last = a[i]	#update the last element
            c=1	#initialize count
        else	# not a new element, 
            c+=1 #increment count
        end
    end
    ar #return the sequence
end

#this recursive method returns a list of the elements of the next line of 
#the serie. 'a' being the current line unless we are at the line number l.
# 'i' represents the actual line number
def serie (a,l,i=1)
   STDERR.puts a.join(' ')
   a = serie(parse(a),l,i+1) if( i< l )   #repeat as long as the current line's number is not l
   a
end

#reading input
n = gets.to_i #first element
l = gets.to_i #requested line
a = [n]       #this is a list of the elements in the line to be displayed
puts serie(a,l).join(' ')  #we display that list joined by spaces

