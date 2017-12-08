package com.fjc.controller;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fjc.entity.SmbmsProvider;
import com.fjc.service.SmbmsProviderService;

@Controller
public class SmbmsProviderController {
	@Autowired
	private SmbmsProviderService ps;
	private int pageSize=5;
	@RequestMapping("provider.do")
	public String getSmbmsProvider(String proCode,String proName,@RequestParam(defaultValue="1") int pageIndex,Map<String,Object> model){
		
		int totalCount = ps.getProviderRow(proCode, proName);
		int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		model.put("providerList", ps.getSmbmsProvider(proCode, proName, pageIndex, pageSize));
		model.put("currentPageNo",pageIndex);
		model.put("totalPageCount",totalPageCount);
		model.put("totalCount",totalCount);
		model.put("proCode",proCode);
		model.put("proName",proName);
		
		return "jsp/providerlist";
		
	}
	@RequestMapping("addprovider.do")
	public String addSmbmsProvider(SmbmsProvider provider){
		if (ps.addSmbmsProvider(provider)>0) {
			return "redirect:provider.do";
		}
		
		return "jsp/provideradd";
		
	}
	@RequestMapping("delprovider.do")
	public String delSmbmsProvider(Long id){
		if (ps.delSmbmsProvider(id)>0) {
			return "redirect:provider.do";
		}
		return "jsp/providerlist";
		
	}
	
	/*@RequestMapping("addprovider.do")
	public String addUser(@ModelAttribute("provider") @Valid SmbmsProvider provider,BindingResult result,@RequestParam("photos") MultipartFile[] photos,HttpServletRequest req){
		if(!result.hasErrors()){
			String path = req.getSession().getServletContext().getRealPath("photos");
			List<String> errors = new ArrayList<String>();
			List<String> filenames = new ArrayList<String>();
			//1.���
			for(MultipartFile photo:photos){
				String err = getErrInfo(photo);
				//2.�ϴ�
				if(err == null){
					String fileName = upload(photo, path);
					filenames.add(fileName);
				}else{
					errors.add(err);
				}
			}
			
			if(filenames.size() > 0){
				provider.setPhotoPath("photos"+File.separator+filenames.get(0));
				if(ps.addSmbmsProvider(provider)>0){
					return "redirect:provider.do";
				}
			}
			req.setAttribute("errors", errors);
			req.setAttribute("filenames", filenames);
		}
		return "jsp/provideradd";
	}
	*//**
	 * 
	 * @param photo
	 * @param path
	 * @return
	 *//*
	public String upload(MultipartFile photo,String path){
		String fileName = photo.getOriginalFilename();
		long time = System.currentTimeMillis();
		int randNumber = RandomUtils.nextInt(1000000);
		File dest = new File(path,time+"_"+randNumber+"_"+fileName);
		try {
			photo.transferTo(dest);
			return fileName;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	*//**
	 * //1).�ϴ����ļ��Ƿ�Ϊ��
		//2).�ϴ��ļ��Ĵ�С
		//3).�ϴ��ļ��ĸ�ʽ
	 * @param photo
	 * @return null is ok!!!
	 *//*
	public String getErrInfo(MultipartFile photo){
		String fileName = photo.getOriginalFilename();
		String suf = FilenameUtils.getExtension(fileName);
		String err = null;
		if(photo.isEmpty()){
			err = String.format("%s���ϴ��ļ�����Ϊ��",fileName);
		}else if(photo.getSize()>500000){
			err = String.format("%s���ϴ��ļ���С���ܳ���500KB",fileName);
		}else if(!formats.contains(suf.toLowerCase())){
			err = String.format("%s���ϴ��ļ���ʽ����ȷ��֧�ֵĸ�ʽ��%s",fileName,formats);
		}
		return err;
	}
	static List<String> formats = new ArrayList<String>();
	static{
		formats.add("png");
		formats.add("jpg");
		formats.add("jpeg");
		formats.add("pneg");
	}
	*/
}
