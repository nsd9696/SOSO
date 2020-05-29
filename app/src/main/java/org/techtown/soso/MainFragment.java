package org.techtown.soso;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_lee, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recyclerview);
        List<Item> itemList=new ArrayList<>();

        Item item1=new Item(R.drawable.person);
        Item item2=new Item(R.drawable.find);
        Item item3=new Item(R.drawable.person);

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        MyAdapter myAdapter=new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myviewholder> {

        List<Item> mitemlist;

        public MyAdapter(List<Item> itemList)    {
            mitemlist=itemList;
        }
        @NonNull
        @Override
        public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View convertview=LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            Myviewholder myviewholder=new Myviewholder(convertview);
            return myviewholder;
        }

        @Override
        public void onBindViewHolder(@NonNull Myviewholder holder, final int position) {
            Item item=mitemlist.get(position);
            holder.imageView.setImageResource(item.imageid);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"click"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mitemlist.size();
        }

        public class Myviewholder extends RecyclerView.ViewHolder {

            ImageView imageView;

            public Myviewholder(@NonNull View itemView) {
                super(itemView);
                imageView=(ImageView)itemView.findViewById(R.id.myviewholder_image);
            }
        }
        }

    }