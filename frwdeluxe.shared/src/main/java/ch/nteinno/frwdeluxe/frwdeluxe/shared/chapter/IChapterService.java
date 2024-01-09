package ch.nteinno.frwdeluxe.frwdeluxe.shared.chapter;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

@TunnelToServer
public interface IChapterService extends IService {
  ChapterFormData prepareCreate(ChapterFormData formData);

  ChapterFormData create(ChapterFormData formData);

  ChapterFormData load(ChapterFormData formData);

  ChapterFormData store(ChapterFormData formData);
}
