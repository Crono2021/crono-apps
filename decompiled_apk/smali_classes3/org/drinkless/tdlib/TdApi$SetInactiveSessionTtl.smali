.class public Lorg/drinkless/tdlib/TdApi$SetInactiveSessionTtl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetInactiveSessionTtl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5d9ca950


# instance fields
.field public inactiveSessionTtlDays:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19735
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 19725
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19726
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetInactiveSessionTtl;->inactiveSessionTtlDays:I

    .line 19727
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19731
    const v0, 0x5d9ca950

    return v0
.end method
