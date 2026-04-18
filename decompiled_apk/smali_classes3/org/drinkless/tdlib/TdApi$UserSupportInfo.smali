.class public Lorg/drinkless/tdlib/TdApi$UserSupportInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserSupportInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4af1e3d7


# instance fields
.field public author:Ljava/lang/String;

.field public date:I

.field public message:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42022
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42023
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;I)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i9"    # I

    .line 42011
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42012
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UserSupportInfo;->message:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 42013
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UserSupportInfo;->author:Ljava/lang/String;

    .line 42014
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UserSupportInfo;->date:I

    .line 42015
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42019
    const v0, -0x4af1e3d7

    return v0
.end method
