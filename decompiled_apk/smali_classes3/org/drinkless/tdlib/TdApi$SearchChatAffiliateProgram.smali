.class public Lorg/drinkless/tdlib/TdApi$SearchChatAffiliateProgram;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchChatAffiliateProgram"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chat;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4fd3f646


# instance fields
.field public referrer:Ljava/lang/String;

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30508
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30509
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 30498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30499
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchChatAffiliateProgram;->username:Ljava/lang/String;

    .line 30500
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchChatAffiliateProgram;->referrer:Ljava/lang/String;

    .line 30501
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30505
    const v0, -0x4fd3f646

    return v0
.end method
