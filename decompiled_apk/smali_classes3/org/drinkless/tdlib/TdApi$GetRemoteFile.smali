.class public Lorg/drinkless/tdlib/TdApi$GetRemoteFile;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetRemoteFile"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$File;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7f632732


# instance fields
.field public fileType:Lorg/drinkless/tdlib/TdApi$FileType;

.field public remoteFileId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26624
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26625
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$FileType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "fileType"    # Lorg/drinkless/tdlib/TdApi$FileType;

    .line 26614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26615
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetRemoteFile;->remoteFileId:Ljava/lang/String;

    .line 26616
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetRemoteFile;->fileType:Lorg/drinkless/tdlib/TdApi$FileType;

    .line 26617
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26621
    const v0, 0x7f632732

    return v0
.end method
