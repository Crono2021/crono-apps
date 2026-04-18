.class public Lorg/drinkless/tdlib/TdApi$UpdateChatPosition;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatPosition"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x890589


# instance fields
.field public chatId:J

.field public position:Lorg/drinkless/tdlib/TdApi$ChatPosition;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34248
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34249
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatPosition;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatPosition"    # Lorg/drinkless/tdlib/TdApi$ChatPosition;

    .line 34238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34239
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatPosition;->chatId:J

    .line 34240
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatPosition;->position:Lorg/drinkless/tdlib/TdApi$ChatPosition;

    .line 34241
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34245
    const v0, -0x890589

    return v0
.end method
