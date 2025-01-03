import java.util.*;
public class greedy{
    
    public static void main(String[] args) { 
        int n=4,m=6;
            Integer costver[]={2,1,3,1,4};
            Integer costhor[]={4,1,2};
            Arrays.sort(costver, Collections.reverseOrder());
            Arrays.sort(costhor, Collections.reverseOrder()); 
            int h=0,v=0;//horizontal or vertical cuts
            int vp=1,hp=1;// horizontal or vertical pieces
            int cost=0;

            while(h<costhor.length&&v<costver.length){
                if(costver[v]<=costhor[h]){ //horizontal cut

                    cost+=(costhor[h]*vp);//horizontal piece ki cost* kitne vertical pieces ko cut kar raha hai
                    hp++;
                    h++;
                }
                else{
                    cost+=(costver[v]*hp); //vertical cut
                    vp++;
                    v++;
                }
            }

while(h<costhor.length){
    cost+=(costhor[v]*vp);
                    hp++;
                    h++;

}
while(v<costver.length){
    cost+=(costver[h]*hp); //vertical cut
                    vp++;
                    v++;

}
System.out.println(cost);

       
    }
}

//  Integer currency[]={1,2,5,10,20,50,100,500,2000};
//         Arrays.sort(currency,Comparator.reverseOrder());
//         int val=121;
//         int count=0;
//         for(int i=0;i<currency.length;i++){
//             if(val>=currency[i]){
//                 while(val>=currency[i]){
//                     val=val-currency[i];
//                     count++;
                    

//                 }
//             }
//         }
//         System.out.println(val+count);
// //                                                       O(nlogn)
//         int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
//         Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));//comparing 2nd number of pairs
//         int chainlen=1;
//         int chainEnd=pairs[0][1];
//         for(int i=0;i<pairs.length;i++){
//             if(pairs[i][0]>=chainEnd){
//                 chainlen++;
//                 chainEnd=pairs[i][1];

//             }
//         }
//        System.out.println(chainlen);
        
//                                                                    ABSOLUTE  MINIMUM DIFFERENCE
//  int a[]={1,2,3};
//         int b[]={2,1,3};
//         Arrays.sort(a);
//         Arrays.sort(b);
//         int mindiff=0;
//         for(int i=0;i<a.length;i++){
//             mindiff+=Math.abs(a[i]-b[i]);
//         }
//         System.out.println(mindiff);
       
//                                                                           //KNAPSACK FRACTIONAL PROBLEM
//         int val[]={60,100,120};
//     int weight[]={10,20,30};
//     int knapsackweight=50;

    

    // double ratio[][]=new double[val.length][2];
    // //calculating ratio
    // //0th column=index, 1st col=ratio
    // for(int i=0;i<val.length;i++){
    //     ratio[i][0]=i;//storing index
    //     ratio[i][1]=val[i]/(double)weight[i];
    // }
    // //ascending order
    // Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
    // int capacity=knapsackweight;

    // //for descending order
    // int finalval=0;
    // for(int i=ratio.length-1;i>=0;i--){
    //     int idx=(int)ratio[i][0];//indexing
    //     if(capacity>=weight[idx]){
    //         finalval+=val[idx];
    //         capacity=capacity-weight[idx];
    //     }
    //     else{
    //         finalval+=(ratio[i][1]*capacity);
    //         capacity=0;
    //         break;
    //     }
        
    // }
    // System.out.println(finalval);
    
//                                                                                        O(nlogn)
//                                                                                  ACTIVITY SELECTION
//    int start[]={1,3,0,5,8,5};
//         int end[]={2,4,6,7,9,9};
        
//         //if array is not sorted
//         int activites[][]= new int[start.length][3];
          
//         for(int i=0;i<start.length;i++){
//             activites[i][0]=i;
//             activites[i][1]=start[i];
//             activites[i][2]=end[i];
//         }
//         Arrays.sort(activites,Comparator.comparingDouble(o->o[2]));
        

//         ArrayList<Integer> a= new ArrayList<>();
//         int maxact=0;
//      // ek baar toh activity perform hogi
//         maxact=1;
//         a.add(activites[0][0]);      //  a.add(0);

//         int lastend=activites[0][2];      //  int lastend=end[0];

//         for(int i=0;i<end.length;i++){
//             if(activites[i][1]>=lastend){//start[i]
//                 maxact++;
//                 a.add(activites[i][0]);// adding index to the answer
//                 lastend=activites[i][2];// jo activity select hue hai uska ending time "end" index se
//             }
//         }
//         System.out.println("max activites:" +maxact);
//         for(int i=0;i<a.size();i++){
//             System.out.print("A"+a.get(i)+" ");
//         }
//         System.out.println();