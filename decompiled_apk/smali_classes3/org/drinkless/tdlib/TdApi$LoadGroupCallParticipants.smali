.class public Lorg/drinkless/tdlib/TdApi$LoadGroupCallParticipants;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoadGroupCallParticipants"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x37f3bece


# instance fields
.field public groupCallId:I

.field public limit:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28144
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28145
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 28134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28135
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$LoadGroupCallParticipants;->groupCallId:I

    .line 28136
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$LoadGroupCallParticipants;->limit:I

    .line 28137
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28141
    const v0, 0x37f3bece

    return v0
.end method
