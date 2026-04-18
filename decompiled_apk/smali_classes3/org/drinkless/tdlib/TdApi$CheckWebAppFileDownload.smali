.class public Lorg/drinkless/tdlib/TdApi$CheckWebAppFileDownload;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckWebAppFileDownload"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1735bb1e


# instance fields
.field public botUserId:J

.field public fileName:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36344
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36345
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;

    .line 36333
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36334
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CheckWebAppFileDownload;->botUserId:J

    .line 36335
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CheckWebAppFileDownload;->fileName:Ljava/lang/String;

    .line 36336
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$CheckWebAppFileDownload;->url:Ljava/lang/String;

    .line 36337
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36341
    const v0, -0x1735bb1e

    return v0
.end method
