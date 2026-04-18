.class public Lorg/drinkless/tdlib/TdApi$CheckCreatedPublicChatsLimit;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckCreatedPublicChatsLimit"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1a8e805f


# instance fields
.field public type:Lorg/drinkless/tdlib/TdApi$PublicChatType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10609
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PublicChatType;)V
    .locals 0
    .param p1, "publicChatType"    # Lorg/drinkless/tdlib/TdApi$PublicChatType;

    .line 10599
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10600
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CheckCreatedPublicChatsLimit;->type:Lorg/drinkless/tdlib/TdApi$PublicChatType;

    .line 10601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10605
    const v0, -0x1a8e805f

    return v0
.end method
