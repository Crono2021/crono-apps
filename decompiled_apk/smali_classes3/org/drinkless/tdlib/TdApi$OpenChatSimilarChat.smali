.class public Lorg/drinkless/tdlib/TdApi$OpenChatSimilarChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OpenChatSimilarChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x70590bed


# instance fields
.field public chatId:J

.field public openedChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28905
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 28894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28895
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$OpenChatSimilarChat;->chatId:J

    .line 28896
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$OpenChatSimilarChat;->openedChatId:J

    .line 28897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28901
    const v0, -0x70590bed

    return v0
.end method
