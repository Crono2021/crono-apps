.class public Lorg/drinkless/tdlib/TdApi$SetChatAffiliateProgram;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatAffiliateProgram"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xe00237


# instance fields
.field public chatId:J

.field public parameters:Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31148
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31149
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "affiliateProgramParameters"    # Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;

    .line 31138
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31139
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatAffiliateProgram;->chatId:J

    .line 31140
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatAffiliateProgram;->parameters:Lorg/drinkless/tdlib/TdApi$AffiliateProgramParameters;

    .line 31141
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31145
    const v0, 0xe00237

    return v0
.end method
