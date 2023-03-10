package dev.said.onlinemedclinic.services;

import dev.said.onlinemedclinic.dao.DocumentDAO;
import dev.said.onlinemedclinic.domains.Document;
import jakarta.servlet.http.HttpServletRequest;

public class DocumentService implements Service<Document> {
    private static final ThreadLocal<DocumentService> instance = ThreadLocal.withInitial(DocumentService::new);

    public static DocumentService getInstance() {
        return instance.get();
    }
    @Override
    public Response<Document> service(HttpServletRequest request) {
        return null;
    }

    @Override
    public Response<Document> save(HttpServletRequest request) {
        return null;
    }

    @Override
    public Response<Document> update(HttpServletRequest request) {
        return null;
    }

    @Override
    public Response<Document> delete(HttpServletRequest request) {
        return null;
    }

    @Override
    public Response<Document> get(HttpServletRequest request) {
        return null;
    }

    @Override
    public Response<Document> get(Integer id) {
        return null;
    }

    public Document get(String filename) {
        return DocumentDAO.getInstance().get(filename);
    }
}
