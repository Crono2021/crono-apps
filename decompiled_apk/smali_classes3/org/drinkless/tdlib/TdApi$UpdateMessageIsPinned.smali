.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageIsPinned;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageIsPinned"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x41bc233d


# instance fields
.field public chatId:J

.field public isPinned:Z

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41759
    return-void
.end method

.method public constructor <init>(JJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z

    .line 41747
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41748
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageIsPinned;->chatId:J

    .line 41749
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageIsPinned;->messageId:J

    .line 41750
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageIsPinned;->isPinned:Z

    .line 41751
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41755
    const v0, 0x41bc233d

    return v0
.end method
