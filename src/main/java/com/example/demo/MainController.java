package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
@RequestMapping("/")
public ModelAndView index(ModelAndView mv) {
mv.addObject("name","名前がここに入ります");
mv.setViewName("index");
return mv;
}

@RequestMapping("/test")
public ModelAndView test(ModelAndView mv) {
mv.addObject("name","test");
mv.setViewName("index");
return mv;
}

@RequestMapping(value="/post",method=RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv) {
mv.addObject("name","名前がここに入ります");
mv.addObject("age","年齢がここに入ります");
mv.addObject("height","身長がここに入ります");
mv.setViewName("day20");
return mv;
}

@RequestMapping(value="/post",method=RequestMethod.POST)
public ModelAndView indexPost(ModelAndView mv,@RequestParam("nameVal")String name,@RequestParam("ageVal")String age,@RequestParam("heightVal")String height) {
mv.addObject("name",name);
mv.addObject("age",age);
mv.addObject("height",height);
mv.setViewName("day20");
return mv;
}

@RequestMapping(value="/kaijou",method=RequestMethod.GET)
public ModelAndView kaijouGet(ModelAndView mv) {
mv.addObject("kekka","階乗の計算をします");
mv.setViewName("kaijou");
return mv;
}

@RequestMapping(value="/kaijou",method=RequestMethod.POST)
public ModelAndView kaijouPost(ModelAndView mv,@RequestParam("kekkaVal")int kekka){
	int x = 0;
	int y = kekka;
	while(y>0) {
		x = x + y;
		y = y - 1;
	}
mv.addObject("kekka",kekka+"の階乗は"+x+"です!");
mv.setViewName("kaijou");
return mv;
}

@RequestMapping(value="/if",method=RequestMethod.GET)
public ModelAndView ifGet(ModelAndView mv) {
	mv.addObject("suzuki",false);
	mv.setViewName("if");
	return mv;
}

@RequestMapping(value="/if",method=RequestMethod.POST)
public ModelAndView ifPost(ModelAndView mv) {
	mv.addObject("suzuki",true);
	mv.setViewName("if");
	return mv;
}

@RequestMapping("/name/{name}")
public ModelAndView url(@PathVariable String name,ModelAndView mv) {
mv.addObject("name",name);
mv.setViewName("url");
return mv;
}

@RequestMapping("/aaa/{num}")
public ModelAndView url(@PathVariable int num,ModelAndView mv) {
String line="";
for(int i=0;i<num;i++)line+="あ";
mv.addObject("name",line);
mv.setViewName("url");
return mv;
}

@RequestMapping("/sosu/{x}")
public ModelAndView sosu(@PathVariable int x,ModelAndView mv) {
	String line="は素数です！";
int y = x - 1;
while(y>1) {
	if(x % y == 0) {
		line ="は素数ではありません...";
		break;
	}
	y = y - 1;
}
mv.addObject("kekka",x+line);
mv.setViewName("sosu");
return mv;
}

}
