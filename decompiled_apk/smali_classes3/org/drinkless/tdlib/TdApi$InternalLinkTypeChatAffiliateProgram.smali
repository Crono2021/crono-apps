.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeChatAffiliateProgram;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeChatAffiliateProgram"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x25ac5024


# instance fields
.field public referrer:Ljava/lang/String;

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27644
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27645
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 27634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27635
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeChatAffiliateProgram;->username:Ljava/lang/String;

    .line 27636
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeChatAffiliateProgram;->referrer:Ljava/lang/String;

    .line 27637
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27641
    const v0, 0x25ac5024

    return v0
.end method
