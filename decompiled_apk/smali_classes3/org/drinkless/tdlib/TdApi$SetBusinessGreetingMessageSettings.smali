.class public Lorg/drinkless/tdlib/TdApi$SetBusinessGreetingMessageSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessGreetingMessageSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x340ac3c3


# instance fields
.field public greetingMessageSettings:Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19519
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;)V
    .locals 0
    .param p1, "businessGreetingMessageSettings"    # Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;

    .line 19509
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19510
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessGreetingMessageSettings;->greetingMessageSettings:Lorg/drinkless/tdlib/TdApi$BusinessGreetingMessageSettings;

    .line 19511
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19515
    const v0, -0x340ac3c3    # -3.2143482E7f

    return v0
.end method
