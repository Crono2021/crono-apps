.class public Lorg/drinkless/tdlib/TdApi$File;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "File"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b4c4e34


# instance fields
.field public expectedSize:J

.field public id:I

.field public local:Lorg/drinkless/tdlib/TdApi$LocalFile;

.field public remote:Lorg/drinkless/tdlib/TdApi$RemoteFile;

.field public size:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47229
    return-void
.end method

.method public constructor <init>(IJJLorg/drinkless/tdlib/TdApi$LocalFile;Lorg/drinkless/tdlib/TdApi$RemoteFile;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "localFile"    # Lorg/drinkless/tdlib/TdApi$LocalFile;
    .param p7, "remoteFile"    # Lorg/drinkless/tdlib/TdApi$RemoteFile;

    .line 47215
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47216
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$File;->id:I

    .line 47217
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$File;->size:J

    .line 47218
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$File;->expectedSize:J

    .line 47219
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$File;->local:Lorg/drinkless/tdlib/TdApi$LocalFile;

    .line 47220
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$File;->remote:Lorg/drinkless/tdlib/TdApi$RemoteFile;

    .line 47221
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47225
    const v0, 0x4b4c4e34    # 1.3389364E7f

    return v0
.end method
