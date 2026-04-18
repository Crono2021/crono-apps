.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeFragment;
.super Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeTypeFragment"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ef08b33


# instance fields
.field public length:I

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22984
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 22985
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 22974
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 22975
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeFragment;->url:Ljava/lang/String;

    .line 22976
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeFragment;->length:I

    .line 22977
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22981
    const v0, -0x7ef08b33

    return v0
.end method
