.class public Lorg/drinkless/tdlib/TdApi$SetChatLocation;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatLocation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2db8e256


# instance fields
.field public chatId:J

.field public location:Lorg/drinkless/tdlib/TdApi$ChatLocation;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31269
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatLocation;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatLocation"    # Lorg/drinkless/tdlib/TdApi$ChatLocation;

    .line 31258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31259
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatLocation;->chatId:J

    .line 31260
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatLocation;->location:Lorg/drinkless/tdlib/TdApi$ChatLocation;

    .line 31261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31265
    const v0, -0x2db8e256

    return v0
.end method
