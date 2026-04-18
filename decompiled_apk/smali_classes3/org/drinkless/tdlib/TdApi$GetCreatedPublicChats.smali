.class public Lorg/drinkless/tdlib/TdApi$GetCreatedPublicChats;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetCreatedPublicChats"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chats;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2a5725ef


# instance fields
.field public type:Lorg/drinkless/tdlib/TdApi$PublicChatType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12679
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PublicChatType;)V
    .locals 0
    .param p1, "publicChatType"    # Lorg/drinkless/tdlib/TdApi$PublicChatType;

    .line 12669
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12670
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetCreatedPublicChats;->type:Lorg/drinkless/tdlib/TdApi$PublicChatType;

    .line 12671
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12675
    const v0, 0x2a5725ef

    return v0
.end method
