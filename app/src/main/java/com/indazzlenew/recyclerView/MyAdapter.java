package com.indazzlenew.recyclerView;

/**
 * Created by user on 04-07-2016.
 */

//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ProductViewHolder> {
   /*     private ArrayList<String> mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ProductViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case

            public TextView txtHeader;
            public TextView txtFooter;

              public ProductViewHolder(View v) {
                super(v);
               // txtHeader = (TextView) v.findViewById(R.id.firstLine);
                //txtFooter = (TextView) v.findViewById(R.id.secondLine);
            }
        }

        public void add(int position, String item) {
            mDataset.add(position, item);
            notifyItemInserted(position);
        }

        public void remove(String item) {
            int position = mDataset.indexOf(item);
            mDataset.remove(position);
            notifyItemRemoved(position);
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<String> myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowproducts, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ProductViewHolder vh = new ProductViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ProductViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            final String name = mDataset.get(position);
            holder.txtHeader.setText(mDataset.get(position));
            holder.txtHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(name);
                }
            });

            holder.txtFooter.setText("Footer: " + mDataset.get(position));

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }

*/
//}
