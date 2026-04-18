.class public Lorg/drinkless/tdlib/TdApi$SetUserSupportInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetUserSupportInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$UserSupportInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7c8367fd


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32208
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32209
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 32198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32199
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetUserSupportInfo;->userId:J

    .line 32200
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetUserSupportInfo;->message:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 32201
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32205
    const v0, -0x7c8367fd

    return v0
.end method
