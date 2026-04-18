.class public Lorg/drinkless/tdlib/TdApi$DeleteBusinessMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteBusinessMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x54fac9e4


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public messageIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24925
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "jArr"    # [J

    .line 24914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24915
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteBusinessMessages;->businessConnectionId:Ljava/lang/String;

    .line 24916
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$DeleteBusinessMessages;->messageIds:[J

    .line 24917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24921
    const v0, 0x54fac9e4

    return v0
.end method
