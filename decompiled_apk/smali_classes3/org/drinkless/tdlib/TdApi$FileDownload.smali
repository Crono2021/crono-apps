.class public Lorg/drinkless/tdlib/TdApi$FileDownload;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FileDownload"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7cb2ecac


# instance fields
.field public addDate:I

.field public completeDate:I

.field public fileId:I

.field public isPaused:Z

.field public message:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47255
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$Message;IIZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p3, "i10"    # I
    .param p4, "i11"    # I
    .param p5, "z8"    # Z

    .line 47241
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47242
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$FileDownload;->fileId:I

    .line 47243
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FileDownload;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 47244
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$FileDownload;->addDate:I

    .line 47245
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$FileDownload;->completeDate:I

    .line 47246
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$FileDownload;->isPaused:Z

    .line 47247
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47251
    const v0, -0x7cb2ecac

    return v0
.end method
