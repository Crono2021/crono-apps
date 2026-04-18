.class public Lorg/drinkless/tdlib/TdApi$RemoteFile;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoteFile"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2c917856


# instance fields
.field public id:Ljava/lang/String;

.field public isUploadingActive:Z

.field public isUploadingCompleted:Z

.field public uniqueId:Ljava/lang/String;

.field public uploadedSize:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48502
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48503
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZZJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "j5"    # J

    .line 48489
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48490
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RemoteFile;->id:Ljava/lang/String;

    .line 48491
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RemoteFile;->uniqueId:Ljava/lang/String;

    .line 48492
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$RemoteFile;->isUploadingActive:Z

    .line 48493
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$RemoteFile;->isUploadingCompleted:Z

    .line 48494
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$RemoteFile;->uploadedSize:J

    .line 48495
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48499
    const v0, 0x2c917856

    return v0
.end method
