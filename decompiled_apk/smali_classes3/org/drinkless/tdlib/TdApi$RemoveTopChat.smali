.class public Lorg/drinkless/tdlib/TdApi$RemoveTopChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveTopChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x71b7e1ab


# instance fields
.field public category:Lorg/drinkless/tdlib/TdApi$TopChatCategory;

.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30008
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30009
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$TopChatCategory;J)V
    .locals 0
    .param p1, "topChatCategory"    # Lorg/drinkless/tdlib/TdApi$TopChatCategory;
    .param p2, "j5"    # J

    .line 29998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29999
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveTopChat;->category:Lorg/drinkless/tdlib/TdApi$TopChatCategory;

    .line 30000
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$RemoveTopChat;->chatId:J

    .line 30001
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30005
    const v0, -0x71b7e1ab

    return v0
.end method
