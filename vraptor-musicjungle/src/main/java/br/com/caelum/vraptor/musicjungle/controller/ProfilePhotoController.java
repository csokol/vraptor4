package br.com.caelum.vraptor.musicjungle.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.musicjungle.interceptor.Public;
import br.com.caelum.vraptor.paperclip.UploadedImage;
import br.com.caelum.vraptor.paperclip.crop.CenteredCrop;
import br.com.caelum.vraptor.paperclip.crop.Crop;
import br.com.caelum.vraptor.paperclip.crop.CropType;
import br.com.caelum.vraptor.paperclip.crop.ImageCropper;
import br.com.caelum.vraptor.paperclip.resize.ImageResizer;
import br.com.caelum.vraptor.paperclip.resize.SimpleResize;

@Controller
public class ProfilePhotoController {
	
	@Inject
	private Result result;
	
	@Inject
	private ImageResizer resizer;
	
	@Inject
	private ImageCropper cropper;

	@Public
	@Get("/profile/upload")
	public void uploadForm() {
	}
	
	@Public
	@Post("/profile/upload")
	public void savePhoto(@Crop(width=100, height=100, type=CropType.TOP_LEFT) UploadedImage image) {
		image.save("/images/upload.png");
		resizer.resize(image, new SimpleResize(200, 200)).save("/images/upload2.png");
		
		cropper.crop(image, new CenteredCrop(image, 50, 50));
		
		result.redirectTo(this).uploadForm();
	}
}
