.class public Lorg/drinkless/tdlib/TdApi$SetUserNote;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetUserNote"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x14f346a7


# instance fields
.field public note:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32148
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32149
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 32138
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32139
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetUserNote;->userId:J

    .line 32140
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetUserNote;->note:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 32141
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32145
    const v0, -0x14f346a7

    return v0
.end method
