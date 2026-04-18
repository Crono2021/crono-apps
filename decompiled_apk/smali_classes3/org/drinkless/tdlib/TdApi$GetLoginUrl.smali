.class public Lorg/drinkless/tdlib/TdApi$GetLoginUrl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetLoginUrl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2f3295d1


# instance fields
.field public allowWriteAccess:Z

.field public buttonId:J

.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43446
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43447
    return-void
.end method

.method public constructor <init>(JJJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "z8"    # Z

    .line 43434
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43435
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetLoginUrl;->chatId:J

    .line 43436
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetLoginUrl;->messageId:J

    .line 43437
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$GetLoginUrl;->buttonId:J

    .line 43438
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$GetLoginUrl;->allowWriteAccess:Z

    .line 43439
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43443
    const v0, 0x2f3295d1

    return v0
.end method
