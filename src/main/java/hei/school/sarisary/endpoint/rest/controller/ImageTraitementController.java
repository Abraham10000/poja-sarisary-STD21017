package hei.school.sarisary.endpoint.rest.controller;

import hei.school.sarisary.service.ImageTraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageTraitementController {

  private final ImageTraitementService imageTraitementService;

  @Autowired
  public ImageTraitementController(ImageTraitementService imageTraitementService) {
    this.imageTraitementService = imageTraitementService;
  }

  @RequestMapping(
          path = "/black-and-white/{id}",
          method = RequestMethod.PUT,
          consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
  )
  public ResponseEntity<String> putBlackAndWhite(
          @PathVariable String id,
          @RequestPart("file") MultipartFile file) throws IOException {
    this.imageTraitementService.process(id, file);
    return ResponseEntity.status(HttpStatus.OK).body("OK");
  }
}
