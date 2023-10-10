package com.example.springdatabasicdemo.dtos;

public class CountDto
{
    public  String Name;
    public  long count;

    public CountDto(String Name,long count){
        this.count = count;
        this.Name = Name;
    }
    public String toString() {
        return "CountDto { teamName = " + Name + ", clerksCount = " + count + "}";
    }

    public CountDto() {
    }

    public String _getName() {
        return Name;
    }

    public void _setName(String name) {
        Name = name;
    }

    public long _getCount() {
        return count;
    }

    public void _setCount(int count) {
        this.count = count;
    }
}
