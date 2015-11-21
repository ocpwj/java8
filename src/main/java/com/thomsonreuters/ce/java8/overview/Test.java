package com.thomsonreuters.ce.java8.overview;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Test {

	public static void main(String ... args) throws Exception{
		//1:lambda���ʽ�͹��ܽӿ�
		Add a = (x, y) -> x+y;
		System.out.println(a.add(100,200));
		System.out.println("------------------------------------------1");
		//2:lambda���ʽ�ͼ���
		List<String> list = Arrays.asList("aaa","bbbb","cccc");
		list.forEach(e -> {System.out.println(e);});
		System.out.println("------------------------------------------2");
		//3:�ӿ��п��԰�����̬����
		Add.interfaceStaticMethod();
		System.out.println("------------------------------------------3");
	    //4:�ӿ��п��԰���Ĭ�Ϸ�����Ĭ�Ϸ���ʵ���ಢ���Ǳ���ʵ�֡�
		Add add = (x,y) -> x-y;
		add.defaultMethod();
		System.out.println("------------------------------------------4");
		//5:java.util.function �����ṩ�ĺ���ʽ�ӿ�
		String s = "hello";
		Function<String,String> function = x -> x+" world";
		System.out.println(function.apply(s));
		System.out.println("------------------------------------------5");
		//6:java.util.stream��
		List<Integer> strings = Arrays.asList(1,2,3); 
		IntStream stream = strings.stream().mapToInt(Integer::valueOf);
		stream.forEach(x->{System.out.println(x);});
		
		System.out.println("------------------------------------------6");
		System.out.println(Instant.now().getNano());
		System.out.println(Instant.MIN);
		System.out.println(Instant.MAX);
	}
	
}

@FunctionalInterface	//����ʽ�ӿڣ�Ҳ�й��ܽӿڣ����˽ӿ���ֻ����һ�����󷽷�������ʽ�ӿڿ�����lambda���ʽʵ������
interface Add {
	public int add(int x,int y);
	public static void interfaceStaticMethod(){
		System.out.println("interface static method");
	}
	public default void defaultMethod(){
		System.out.println("default method");
	}
	
}