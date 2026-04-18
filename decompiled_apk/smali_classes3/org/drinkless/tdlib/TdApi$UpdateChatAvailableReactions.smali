.class public Lorg/drinkless/tdlib/TdApi$UpdateChatAvailableReactions;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatAvailableReactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x754bec07


# instance fields
.field public availableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33888
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33889
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatAvailableReactions;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatAvailableReactions"    # Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

    .line 33878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33879
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAvailableReactions;->chatId:J

    .line 33880
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAvailableReactions;->availableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

    .line 33881
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33885
    const v0, -0x754bec07

    return v0
.end method
