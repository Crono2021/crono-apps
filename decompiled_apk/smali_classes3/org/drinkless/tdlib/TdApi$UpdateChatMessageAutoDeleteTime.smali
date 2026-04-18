.class public Lorg/drinkless/tdlib/TdApi$UpdateChatMessageAutoDeleteTime;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatMessageAutoDeleteTime"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x71425de5


# instance fields
.field public chatId:J

.field public messageAutoDeleteTime:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34108
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34109
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 34098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34099
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMessageAutoDeleteTime;->chatId:J

    .line 34100
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatMessageAutoDeleteTime;->messageAutoDeleteTime:I

    .line 34101
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34105
    const v0, 0x71425de5

    return v0
.end method
