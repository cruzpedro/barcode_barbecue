package com.example.barcode.service;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
public class BarbecueService {

    public byte[] generateBarCodeImage(String code) throws BarcodeException, OutputException, IOException {
        Barcode barcode3 = BarcodeFactory.createInt2of5(code);
        barcode3.setResolution(300);
        File file = new File(code + ".png");
        BarcodeImageHandler.savePNG(barcode3, file);
        BufferedImage bufferedImage = BarcodeImageHandler.getImage(barcode3);
        if(!file.delete()) {
            throw new RuntimeException();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();

        return imageInByte;
    }

}
