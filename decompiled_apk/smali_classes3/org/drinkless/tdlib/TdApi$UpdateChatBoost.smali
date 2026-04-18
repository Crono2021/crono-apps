.class public Lorg/drinkless/tdlib/TdApi$UpdateChatBoost;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatBoost"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x50727e24


# instance fields
.field public boost:Lorg/drinkless/tdlib/TdApi$ChatBoost;

.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33949
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatBoost;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatBoost"    # Lorg/drinkless/tdlib/TdApi$ChatBoost;

    .line 33938
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33939
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatBoost;->chatId:J

    .line 33940
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatBoost;->boost:Lorg/drinkless/tdlib/TdApi$ChatBoost;

    .line 33941
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33945
    const v0, 0x50727e24

    return v0
.end method
