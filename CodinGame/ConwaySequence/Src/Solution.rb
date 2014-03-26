def parse(a)
    n = a.length
    c=0
    ar = []
    last = a[0]
    for i in 0..n do
        if last != a[i]
            ar << c
            ar << last 
            last = a[i]
            c=1
        else
            c+=1
        end
    end
    ar 
end
def serie (a,l,i=1)
   STDERR.puts a.join(' ')
   a= serie(parse(a),l,i+1) if( i< l )      
   a
end

n = gets.to_i
l = gets.to_i
a = [n]
puts serie(a,l).join(' ')
