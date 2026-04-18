.class public Lorg/drinkless/tdlib/TdApi$PreliminaryUploadFile;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PreliminaryUploadFile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$File;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x70e7cb99


# instance fields
.field public file:Lorg/drinkless/tdlib/TdApi$InputFile;

.field public fileType:Lorg/drinkless/tdlib/TdApi$FileType;

.field public priority:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38942
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 38943
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputFile;Lorg/drinkless/tdlib/TdApi$FileType;I)V
    .locals 0
    .param p1, "inputFile"    # Lorg/drinkless/tdlib/TdApi$InputFile;
    .param p2, "fileType"    # Lorg/drinkless/tdlib/TdApi$FileType;
    .param p3, "i9"    # I

    .line 38931
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 38932
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PreliminaryUploadFile;->file:Lorg/drinkless/tdlib/TdApi$InputFile;

    .line 38933
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PreliminaryUploadFile;->fileType:Lorg/drinkless/tdlib/TdApi$FileType;

    .line 38934
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PreliminaryUploadFile;->priority:I

    .line 38935
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38939
    const v0, 0x70e7cb99

    return v0
.end method
