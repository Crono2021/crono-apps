.class public Lorg/drinkless/tdlib/TdApi$SetBusinessMessageIsPinned;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessMessageIsPinned"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xeb0a10


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public isPinned:Z

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45222
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45223
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "z8"    # Z

    .line 45210
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45211
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessMessageIsPinned;->businessConnectionId:Ljava/lang/String;

    .line 45212
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessMessageIsPinned;->chatId:J

    .line 45213
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessMessageIsPinned;->messageId:J

    .line 45214
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessMessageIsPinned;->isPinned:Z

    .line 45215
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45219
    const v0, -0xeb0a10

    return v0
.end method
