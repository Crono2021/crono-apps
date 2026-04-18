.class public Lorg/drinkless/tdlib/TdApi$Document;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Document"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x50e65028


# instance fields
.field public document:Lorg/drinkless/tdlib/TdApi$File;

.field public fileName:Ljava/lang/String;

.field public mimeType:Ljava/lang/String;

.field public minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46968
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46969
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Minithumbnail;Lorg/drinkless/tdlib/TdApi$Thumbnail;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;
    .param p4, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;
    .param p5, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 46955
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 46956
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Document;->fileName:Ljava/lang/String;

    .line 46957
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Document;->mimeType:Ljava/lang/String;

    .line 46958
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Document;->minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 46959
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$Document;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 46960
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$Document;->document:Lorg/drinkless/tdlib/TdApi$File;

    .line 46961
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46965
    const v0, -0x50e65028

    return v0
.end method
