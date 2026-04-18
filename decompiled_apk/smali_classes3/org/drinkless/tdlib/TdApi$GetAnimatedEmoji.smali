.class public Lorg/drinkless/tdlib/TdApi$GetAnimatedEmoji;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetAnimatedEmoji"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3f844f76


# instance fields
.field public emoji:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12012
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12013
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 12003
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12004
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetAnimatedEmoji;->emoji:Ljava/lang/String;

    .line 12005
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12009
    const v0, 0x3f844f76

    return v0
.end method
